package ru.sfedu.PlanetGame.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.PlanetGame.models.*;

import java.io.File;
import java.io.IOException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() throws IOException {
        if (sessionFactory == null) {
            // loads configuration and mappings
            String filepath =  ConfigurationUtil.getConfigurationEntry("PATH_TO_CFG_XML");
            File file = new File(filepath);
            Configuration configuration = new Configuration().configure(file);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            addEntities(metadataSources);
            Metadata metadata =  metadataSources.getMetadataBuilder().build();
            sessionFactory =   metadata.getSessionFactoryBuilder().build();
        }

        return sessionFactory;
    }

    private static void addEntities(MetadataSources metadataSources) {
        metadataSources.addAnnotatedClass(Base.class);
        metadataSources.addAnnotatedClass(Unit.class);
        metadataSources.addAnnotatedClass(Planet.class);
        metadataSources.addAnnotatedClass(EnemyPlanet.class);
        metadataSources.addAnnotatedClass(PlayerPlanet.class);
        metadataSources.addAnnotatedClass(ArmyInfo.class);
        metadataSources.addAnnotatedClass(Army.class);
        metadataSources.addAnnotatedClass(Building.class);
        metadataSources.addAnnotatedClass(Resources.class);
        metadataSources.addAnnotatedClass(Game.class);
    }
}