//package com.journaldev.dao;
//
//import org.eclipse.persistence.config.SessionCustomizer;
//import org.eclipse.persistence.descriptors.ClassDescriptor;
//import org.eclipse.persistence.sessions.Session;
//
//import static org.eclipse.persistence.descriptors.CachePolicy.INVALIDATE_CHANGED_OBJECTS;
//
//public class DatabaseSessionCustomizer implements SessionCustomizer {
//
//    @Override
//    public void customize(Session session) throws Exception {
//        session.getDescriptors().values()
//                .forEach(this::customizeDescriptor);
//    }
//
//    private void customizeDescriptor(ClassDescriptor descriptor) {
//        descriptor.setCacheSynchronizationType(INVALIDATE_CHANGED_OBJECTS);
//    }
//}
