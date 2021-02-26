package reskillAssignmentOne;
/*
Samme her som Geography
Kan flyttes til Order som parameter
 */

public class Channel {
    private String channelType;
    private Order order;

    public Channel(String channelType, Order order) {
        this.channelType = channelType;
        this.order = order;
    }
}
