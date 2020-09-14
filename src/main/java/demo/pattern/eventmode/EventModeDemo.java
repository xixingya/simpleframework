package demo.pattern.eventmode;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/31 9:24
 */
public class EventModeDemo {

    public static void main(String[] args) {
        EventSource eventSource=new EventSource();
        SingleClickEventListener singleClickEventListener=new SingleClickEventListener();
        DoubleClickEventListener doubleClickEventListener=new DoubleClickEventListener();
        Event event=new Event();
        event.setType("singleclick");
        eventSource.registerListener(singleClickEventListener);
        eventSource.registerListener(doubleClickEventListener);
        eventSource.publishEvent(event);
    }
}
