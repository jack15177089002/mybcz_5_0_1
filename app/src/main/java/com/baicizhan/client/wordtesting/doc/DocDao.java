package com.baicizhan.client.wordtesting.doc;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.p031db.BaseDao;
import java.util.List;

public class DocDao extends BaseDao {

    public interface IGetFromNetwork {
        void onGet(List<Doc> list);
    }

    public DocDao(SQLiteOpenHelper sQLiteOpenHelper) {
        super(sQLiteOpenHelper);
    }

    public List<Doc> getDocsOrderByGrade() {
        return query("select text as text, grade as grade from tb_doc_info order by grade", Doc.class, new Object[0]);
    }

    public void updateDocs(List<Doc> list) {
        for (Doc doc : list) {
            Log.d("whiz", "update doc start");
            boolean update = update("update tb_doc_info set text=? where grade=?", doc.getText(), Integer.valueOf(doc.getGrade()));
            Log.d("whiz", "update doc success: " + update);
            C0789L.log.info("update doc success [{}]", (Object) Boolean.valueOf(update));
            if (!update) {
                int insert = insert("insert into tb_doc_info (text, grade) values (?, ?)", doc.getText(), Integer.valueOf(doc.getGrade()));
                C0789L.log.info("insert doc col [{}]", (Object) Integer.valueOf(insert));
                Log.d("whiz", "insert doc col: " + insert);
            }
        }
    }
}
