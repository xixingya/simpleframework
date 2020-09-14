package demo.pattern.eventmode;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/31 9:18
 */
public interface EventListener {
    /**
     * 处理事件
     * @param event
     */
    void processEvent(Event event);
}
