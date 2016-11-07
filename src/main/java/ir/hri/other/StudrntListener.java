package ir.hri.other;

import org.hibernate.event.spi.*;

public class StudrntListener implements PostLoadEventListener, PreLoadEventListener {
    public void onPostLoad(PostLoadEvent postLoadEvent) {
        System.out.println("----- onPostLoad -----");
    }

    public void onPreLoad(PreLoadEvent preLoadEvent) {
        System.out.println("----- onPreLoad -----");
    }
}
