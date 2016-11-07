package ir.hri.other;

import ir.hri.Entity.Address;
import ir.hri.Entity.Student;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class StudrntInterceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        StringBuilder out = new StringBuilder("onSave");

        if (entity instanceof Student) {
            out.append(" Student");
        } else if (entity instanceof Address) {
            out.append(" Address");
        }
        System.out.println("----- " + out + " -----");
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
