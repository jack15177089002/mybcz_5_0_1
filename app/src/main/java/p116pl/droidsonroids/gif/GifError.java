package p116pl.droidsonroids.gif;

import com.baicizhan.client.p029fm.service.proxy.FmPlayState;

/* renamed from: pl.droidsonroids.gif.g */
public enum GifError {
    NO_ERROR(0, "No error"),
    OPEN_FAILED(101, "Failed to open given input"),
    READ_FAILED(102, "Failed to read from given input"),
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    NO_SCRN_DSCR(104, "No screen descriptor detected"),
    NO_IMAG_DSCR(105, "No image descriptor detected"),
    NO_COLOR_MAP(106, "Neither global nor local color map found"),
    WRONG_RECORD(107, "Wrong record type detected"),
    DATA_TOO_BIG(108, "Number of pixels bigger than width * height"),
    NOT_ENOUGH_MEM(109, "Failed to allocate required memory"),
    CLOSE_FAILED(110, "Failed to close given input"),
    NOT_READABLE(111, "Given file was not opened for read"),
    IMAGE_DEFECT(112, "Image is defective, decoding aborted"),
    EOF_TOO_SOON(113, "Image EOF detected before image complete"),
    NO_FRAMES(1000, "No frames found, at least one frame required"),
    INVALID_SCR_DIMS(FmPlayState.TYPE_NORMAL_FM, "Invalid screen size, dimensions must be positive"),
    INVALID_IMG_DIMS(FmPlayState.TYPE_MID_FM, "Invalid image size, dimensions must be positive"),
    IMG_NOT_CONFINED(1003, "Image size exceeds screen size"),
    REWIND_FAILED(1004, "Input source rewind has failed, animation is stopped"),
    UNKNOWN(-1, "Unknown error");
    

    /* renamed from: u */
    public final String f6876u;

    /* renamed from: v */
    int f6877v;

    private GifError(int i, String str) {
        this.f6877v = i;
        this.f6876u = str;
    }

    /* renamed from: a */
    static GifError m6840a(int i) {
        GifError[] values;
        for (GifError gVar : values()) {
            if (gVar.f6877v == i) {
                return gVar;
            }
        }
        GifError gVar2 = UNKNOWN;
        gVar2.f6877v = i;
        return gVar2;
    }
}
