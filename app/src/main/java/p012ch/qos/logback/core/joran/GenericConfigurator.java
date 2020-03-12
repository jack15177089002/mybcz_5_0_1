package p012ch.qos.logback.core.joran;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.xml.sax.InputSource;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.joran.event.SaxEvent;
import p012ch.qos.logback.core.joran.event.SaxEventRecorder;
import p012ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p012ch.qos.logback.core.joran.spi.ElementPath;
import p012ch.qos.logback.core.joran.spi.InterpretationContext;
import p012ch.qos.logback.core.joran.spi.Interpreter;
import p012ch.qos.logback.core.joran.spi.JoranException;
import p012ch.qos.logback.core.joran.spi.RuleStore;
import p012ch.qos.logback.core.joran.spi.SimpleRuleStore;
import p012ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.status.StatusUtil;

/* renamed from: ch.qos.logback.core.joran.GenericConfigurator */
public abstract class GenericConfigurator extends ContextAwareBase {
    public Interpreter interpreter;

    public abstract void addImplicitRules(Interpreter interpreter2);

    public abstract void addInstanceRules(RuleStore ruleStore);

    public final void doConfigure(URL url) {
        try {
            informContextOfURLUsedForConfiguration(getContext(), url);
            URLConnection openConnection = url.openConnection();
            openConnection.setUseCaches(false);
            doConfigure(openConnection.getInputStream());
        } catch (IOException e) {
            String str = "Could not open URL [" + url + "].";
            addError(str, e);
            throw new JoranException(str, e);
        }
    }

    public final void doConfigure(String str) {
        doConfigure(new File(str));
    }

    public final void doConfigure(File file) {
        try {
            informContextOfURLUsedForConfiguration(getContext(), file.toURI().toURL());
            doConfigure((InputStream) new FileInputStream(file));
        } catch (IOException e) {
            String str = "Could not open [" + file.getPath() + "].";
            addError(str, e);
            throw new JoranException(str, e);
        }
    }

    public static void informContextOfURLUsedForConfiguration(Context context, URL url) {
        ConfigurationWatchListUtil.setMainWatchURL(context, url);
    }

    public final void doConfigure(InputStream inputStream) {
        try {
            doConfigure(new InputSource(inputStream));
            try {
            } catch (IOException e) {
                String str = "Could not close the stream";
                addError(str, e);
                throw new JoranException(str, e);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                String str2 = "Could not close the stream";
                addError(str2, e2);
                throw new JoranException(str2, e2);
            }
        }
    }

    public void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
    }

    public ElementPath initialElementPath() {
        return new ElementPath();
    }

    public void buildInterpreter() {
        SimpleRuleStore simpleRuleStore = new SimpleRuleStore(this.context);
        addInstanceRules(simpleRuleStore);
        this.interpreter = new Interpreter(this.context, simpleRuleStore, initialElementPath());
        InterpretationContext interpretationContext = this.interpreter.getInterpretationContext();
        interpretationContext.setContext(this.context);
        addImplicitRules(this.interpreter);
        addDefaultNestedComponentRegistryRules(interpretationContext.getDefaultNestedComponentRegistry());
    }

    private final void doConfigure(InputSource inputSource) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!ConfigurationWatchListUtil.wasConfigurationWatchListReset(this.context)) {
            informContextOfURLUsedForConfiguration(getContext(), null);
        }
        SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
        saxEventRecorder.recordEvents(inputSource);
        doConfigure(saxEventRecorder.getSaxEventList());
        if (new StatusUtil(this.context).noXMLParsingErrorsOccurred(currentTimeMillis)) {
            addInfo("Registering current configuration as safe fallback point");
            registerSafeConfiguration();
        }
    }

    public void doConfigure(List<SaxEvent> list) {
        buildInterpreter();
        synchronized (this.context.getConfigurationLock()) {
            this.interpreter.getEventPlayer().play(list);
        }
    }

    public void registerSafeConfiguration() {
        this.context.putObject(CoreConstants.SAFE_JORAN_CONFIGURATION, this.interpreter.getEventPlayer().getCopyOfPlayerEventList());
    }

    public List<SaxEvent> recallSafeConfiguration() {
        return (List) this.context.getObject(CoreConstants.SAFE_JORAN_CONFIGURATION);
    }
}
