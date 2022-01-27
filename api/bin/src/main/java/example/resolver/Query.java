package example.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.model.Weapon;
import example.repository.*;

@Component
public class Query implements GraphQLQueryResolver {

  WeaponRepository weaponRepository;

  @Autowired
  public Query(WeaponRepository repo){
    this.weaponRepository = repo;
  }

  public String findAllWeapons(){
      StringBuilder sb = new StringBuilder();
      for ( Weapon w : weaponRepository.findAll() ) {
        sb.append(w.toString()+"\n");
      }
      return sb.toString();
  }

  public Long countAll(){
    return weaponRepository.count();
  }

}
