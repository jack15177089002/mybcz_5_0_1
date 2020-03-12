package com.baicizhan.client.framework.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseHelper {
    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close the inputstream.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close the Closeable.", (Object) th.getMessage());
                }
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close the outputstream.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close the outputstream.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("fail on close socket: " + socket, (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close the Reader.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close java.sql.Connection.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close java.sql.PreparedStatement.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close java.sql.ResultSet.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close java.sql.Statement.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close android.database.Cursor.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close android.database.SQLiteDatabase.", (Object) e.getMessage());
                }
            }
        }
    }

    public static void close(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("error on close HttpURLConnection.", (Object) e.getMessage());
                }
            }
        }
    }
}
