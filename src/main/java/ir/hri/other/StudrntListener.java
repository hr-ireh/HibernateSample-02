package ir.hri.other;

import ir.hri.Entity.Address;
import ir.hri.Entity.Student;
import org.hibernate.event.spi.*;

public class StudrntListener implements PostLoadEventListener, PreLoadEventListener {
    public void onPostLoad(PostLoadEvent postLoadEvent) {
        StringBuilder stringBuilder = new StringBuilder("onPostLoad");

        if (postLoadEvent.getEntity() instanceof Student) {
            stringBuilder.append(" Student");
        } else if (postLoadEvent.getEntity() instanceof Address) {
            stringBuilder.append(" Address");
        }
        System.out.println("----- " + stringBuilder + " -----");
    }

    public void onPreLoad(PreLoadEvent preLoadEvent) {
        StringBuilder stringBuilder = new StringBuilder("onPreLoad");

        if (preLoadEvent.getEntity() instanceof Student) {
            stringBuilder.append(" Student");
        } else if (preLoadEvent.getEntity() instanceof Address) {
            stringBuilder.append(" Address");
        }
        System.out.println("----- " + stringBuilder + " -----");
    }
}
