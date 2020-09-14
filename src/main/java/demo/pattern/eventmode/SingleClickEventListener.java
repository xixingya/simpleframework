package demo.pattern.eventmode;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/31 9:19
 */
public class SingleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if("singleclick".equals(event.getType())){
            System.out.println("监听到单机事件");
        }
    }
}
