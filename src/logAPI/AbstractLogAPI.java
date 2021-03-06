package logAPI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddie on 2017/7/1.
 */
public abstract class AbstractLogAPI {
    List<MessageMark> messageMarkList;

    File apiFile;

    public AbstractLogAPI() {
        messageMarkList = new ArrayList<>();
    }

    void parseFile() throws IOException {
        if(!apiFile.exists()) {
            System.out.printf("api file: '%s' does not exist.\n", apiFile.getName());
            return;
        }
        messageMarkList = XMLParser.parse(apiFile.getCanonicalPath());
//        List<String> rules = FileIO.read(apiFile.getAbsolutePath());
//        for(int i = 0; i < rules.size(); i++) {
//            String line = rules.get(i);
//            while(line.matches("\\s+") || line.length() == 0) {
//                i++;
//            }
//            MessageMark mark = new MessageMark();
//            mark.name = rules.get(i++);
//            mark.isFinishMark = Boolean.parseBoolean(rules.get(i++));
//            mark.regex = rules.get(i++);
//            messageMarkList.add(mark);
//        }

    }
}
