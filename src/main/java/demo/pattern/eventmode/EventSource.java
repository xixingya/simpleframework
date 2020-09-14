package demo.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/31 9:22
 */
public class EventSource {

    private List<EventListener> listenerList=new ArrayList<>();

    public void registerListener(EventListener eventListener){
        listenerList.add(eventListener);
    }

    public void publishEvent(Event event){
        for (EventListener eventListener : listenerList) {
            eventListener.processEvent(event);
        }
    }
}
