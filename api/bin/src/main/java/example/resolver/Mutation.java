package example.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.model.Weapon;
import example.repository.*;

@Component
public class Mutation implements GraphQLMutationResolver {

  WeaponRepository weaponRepository;

  @Autowired
  public Mutation(WeaponRepository repo){
    this.weaponRepository = repo;
  }

  public String createWeapon(String name, String description){
    Weapon w = new Weapon();
    w.setName(name);
    w.setDescription(description);

    weaponRepository.save(w);

    return w.toString();
  }

}
