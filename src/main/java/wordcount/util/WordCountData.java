package wordcount.util;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

public class WordCountData {
    public static final String[] WORDS= new String[] {
        "To be, or not to be,--that is the question:--",
        "Oracle’s Internet of Things (IoT) Intelligent Applications Cloud can provide you with more visibility",
        "insights and efficiencies by capturing sensor data from connected devices using smart manufacturing,",
        "connected assets, connected logistics, workplace safety, and connected customer experience."
    };
    
    public static DataSet<String> getDefaultTextLineDataSet(ExecutionEnvironment env) {
        return env.fromElements(WORDS);
    }    
}
