package ir.hri.other;


import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class StudrntIntegrator implements Integrator {
    public void integrate(Configuration configuration,
                          SessionFactoryImplementor sessionFactoryImplementor,
                          SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

        EventListenerRegistry eventListenerRegistry =
                sessionFactoryServiceRegistry.getService(EventListenerRegistry.class);

        StudrntListener studrntListener = new StudrntListener();
        eventListenerRegistry.appendListeners(EventType.POST_LOAD, studrntListener);
        eventListenerRegistry.appendListeners(EventType.PRE_LOAD, studrntListener);
    }

    public void integrate(MetadataImplementor metadataImplementor,
                          SessionFactoryImplementor sessionFactoryImplementor,
                          SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

    }

    public void disintegrate(SessionFactoryImplementor sessionFactoryImplementor,
                             SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

    }
}
