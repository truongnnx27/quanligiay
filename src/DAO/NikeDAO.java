/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author space
 */
abstract public class NikeDAO <EntityType, KeyType>
{
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType key);
    abstract public List <EntityType> selectAll();
    abstract public EntityType selectById(KeyType id);
    abstract protected List<EntityType> selectBySQL (String sql, Object ...args);
}
