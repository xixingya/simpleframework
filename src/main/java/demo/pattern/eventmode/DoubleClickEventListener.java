package demo.pattern.eventmode;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/31 9:20
 */
public class DoubleClickEventListener implements EventListener{

    @Override
    public void processEvent(Event event) {
        if("doubleclick".equals(event.getType())){
            System.out.println("监听到双击事件");
        }
    }
}
