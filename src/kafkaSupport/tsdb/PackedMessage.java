package kafkaSupport.tsdb;

import kafkaSupport.MessageType;

import java.io.Serializable;
import java.util.Formatter;
import java.util.Map;

/**
 * Created by Eddie on 2017/7/19.
 */
public class PackedMessage implements Serializable {
    public String containerId;
    public Long timestamp;
    public String name;
    public Map<String, String> tagMap;
    public Double doubleValue;
    public MessageType type;
    public boolean isFinish = false;
    public boolean firstSend = true;

    public PackedMessage(String containerId,
                         Long timeStamp,
                         String name,
                         Map<String, String> tagMap,
                         Double value) {
        this.containerId = containerId;
        this.timestamp = timeStamp;
        this.name = name;
        this.tagMap = tagMap;
        this.doubleValue = value;
        this.type = MessageType.INSTANT;
    }

    public PackedMessage(String containerId,
                         Long timeStamp,
                         String name,
                         Map<String, String> tagMap,
                         Double value,
                         String type) {
        this.containerId = containerId;
        this.timestamp = timeStamp;
        this.name = name;
        this.tagMap = tagMap;
        this.doubleValue = value;
        if(type.equals("period")) {
            this.type = MessageType.PERIOD;
        } else {
            this.type = MessageType.INSTANT;
        }
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("containerId: %s, timestamp: %d, name: %s, isFinish: %b tag: %s, value: %f",
                containerId, timestamp, name, isFinish, tagMap.toString(), doubleValue);
        return formatter.toString();
    }

    public boolean isCounterPart(PackedMessage other) {
        boolean res;
        res = containerId.equals(other.containerId) && name.equals(other.name) && tagMap.equals(other.tagMap);
//        if (name.equals("period:task") && isFinish) {
//            System.out.printf("this id: %s, other id: %s\n", containerId, other.containerId);
//            System.out.printf("this name: %s, other name: %s\n", name, other.name);
//            System.out.printf("this tag: %s, other tag: %s\n", tagMap, other.tagMap);
//        }
        return res;
    }
}
