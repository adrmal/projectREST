package database;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.common.collect.Lists;

import database.entity.PlayerEntity;
import model.Player;

public class PlayerDatabase {

    private static final String HOST = "mydb.c2oxl4b0ychq.us-west-2.rds.amazonaws.com";
    private static final int PORT = 3306;
    private static final String DATABASE = "restapi";
    private static final String USER_NAME = "adrmal";
    private static final String PASSWORD = "123";

    private static EntityManager entityManager;
    
    public static EntityManager getEntityManager() {
        if(entityManager == null) {
            String dbUrl = "jdbc:mysql://" + HOST + ':' + PORT + "/" + DATABASE;

            Map<String, String> properties = new HashMap<String, String>();

            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            properties.put("hibernate.connection.url", dbUrl);
            properties.put("hibernate.connection.username", USER_NAME);
            properties.put("hibernate.connection.password", PASSWORD);
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
            properties.put("hibernate.hbm2ddl.auto", "update");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit", properties);
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }
    
    public Player getPlayer(String stringPlayerId) {
        Long playerId = getId(stringPlayerId);
        
        PlayerEntity playerEntity = getEntityManager().find(PlayerEntity.class, playerId);

        if(playerEntity != null) {
            return buildPlayerResponse(playerEntity);
        }

        return null;
    }

    public Player updatePlayer(String stringPlayerId, Player player) {
        Long playerId = getId(stringPlayerId);
        
        PlayerEntity playerEntity = getEntityManager().find(PlayerEntity.class, playerId);

        if(playerEntity != null) {
            playerEntity.setFirstName(player.getFirstName());
            playerEntity.setLastName(player.getLastName());

            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(playerEntity);
                getEntityManager().getTransaction().commit();
            }
            finally {
                if(getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
            }

            return buildPlayerResponse(playerEntity);
        }

        return null;
    }

    public Player createPlayer(final Player player) {
        PlayerEntity entity = buildPlayerEntity(player, false);

        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        }
        finally {
            if(getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
        }

        return new Player(String.valueOf(entity.getId()), entity.getFirstName(), entity.getLastName(), entity.getDateOfBirth(), entity.getNationality(), entity.getHeight(), entity.getWeight(), entity.getPosition());
    }

    public Collection<Player> getPlayers() {
        Query query = getEntityManager().createNamedQuery("players.findAll");
        List<PlayerEntity> resultList = query.getResultList();

        List<Player> list = Collections.emptyList();

        if(resultList != null && !resultList.isEmpty()) {
            list = Lists.newArrayListWithCapacity(resultList.size());

            for(PlayerEntity player : resultList) {
                list.add(buildPlayerResponse(player));
            }
        }

        return list;
    }

    private Long getId(String stringPlayerId) {
        try {
            return Long.valueOf(stringPlayerId);
        }
        catch (NumberFormatException e) {
        }
        
        return null;
    }
    
    private Player buildPlayerResponse(PlayerEntity playerEntity) {
        return new Player(String.valueOf(playerEntity.getId()), playerEntity.getFirstName(), playerEntity.getLastName(), playerEntity.getDateOfBirth(), playerEntity.getNationality(), playerEntity.getHeight(), playerEntity.getWeight(), playerEntity.getPosition());
    }

    private PlayerEntity buildPlayerEntity(Player player, boolean active) {
        return new PlayerEntity(player.getFirstName(), player.getLastName(), player.getDateOfBirth(), player.getNationality(), player.getHeight(), player.getWeight(), player.getPosition(), active);
    }
    
}
