package url;

import java.io.Serializable;

/**
 * Created by leo on 16-7-30 上午1:24
 */
public class StringPair implements Serializable {

    private String key;
    private String value;

    public StringPair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
