import java.util.Random;
public class Wizard
{
    public static int energy;
    public int maxEnergy;
    public static int health;
    public int maxHealth;
    public String name;
    public static int damageDealt;
    Random rand = new Random();
    
    public Wizard(int e, int h, String n)
    {
        energy = e;
        maxEnergy = energy;
        health = h;
        maxHealth = health;
        name = n;
    }
    
    public Wizard(int e, String n)
    {
        energy = e;
        maxEnergy = energy;
        health = 100;
        maxHealth = health;
        name = n;
    }
    
    public Wizard(String n)
    {
        energy = 150;
        maxEnergy = energy;
        health = 100;
        maxHealth = health;
        name = n;
    }
    
    public void castFireball()
    {
        if(health > 0)
        {
            if(energy < 30)
            {
                health -= 30 - energy;
                System.out.println(name + " sacrifices " + (30 - energy) + " health for energy!");
                energy = 0;
                if(health < 0)
                    health = 0;
            }
            else
            {
                energy -= 30;
            }
            if(health == 0)
                System.out.println("Unfortunately, " + name + " pushes past the body's limits and dies!\n");
            else
            {
                damageDealt += 35;
                System.out.println(name + " casts Fireball for 30 energy and deals 35 damage!");
                int d20 = rand.nextInt(20) + 1;
                if(d20 < 10)
                {
                    health -= 10;
                    System.out.println(name + " rolls a d" + d20 + " and takes 10 damage!");
                    if(health < 0)
                        health = 0;
                }
                else if(d20 < 15)
                {
                    health -= 5;
                    System.out.println(name + " rolls a d" + d20 + " and takes 5 damage!");
                    if(health < 0)
                        health = 0;
                }
                else
                {
                    System.out.println(name + " rolls a d" + d20 + " and avoids the incoming attack!");
                }
                if(health > 0)
                {
                    System.out.println("Energy: " + energy + "/" + maxEnergy);
                    System.out.println("Health: " + health + "/" + maxHealth);
                    System.out.println("Damage Dealt: " + damageDealt + "\n");
                }
                else
                    System.out.println(name + " dies from the incoming attack!");
            }
        }
        else
            System.out.println(name + " is already dead!\n");
    }
    
    public void castSelfHeal()
    {
        if(health > 0)
        {
            if(energy < 40)
            {
                health -= 40 - energy;
                System.out.println(name + " sacrifices " + (40 - energy) + " health for energy!");
                energy = 0;
                if(health < 0)
                    health = 0;
            }
            else
            {
                energy -= 40;
            }
            if(health == 0)
                System.out.println("Unfortunately, " + name + " pushes past the body's limits and dies!\n");
            else
            {
                health += 30;
                if(health > maxHealth)
                    health = maxHealth;
                System.out.println(name + " casts Self-Heal for 40 energy and heals 30 health!");
                int d20 = rand.nextInt(20) + 1;
                if(d20 < 10)
                {
                    health -= 10;
                    System.out.println(name + " rolls a d" + d20 + " and takes 10 damage!");
                    if(health < 0)
                        health = 0;
                }
                else if(d20 < 15)
                {
                    health -= 5;
                    System.out.println(name + " rolls a d" + d20 + " and takes 5 damage!");
                    if(health < 0)
                        health = 0;
                }
                else
                {
                    System.out.println(name + " rolls a d" + d20 + " and avoids the incoming attack!");
                }
                System.out.println("Energy: " + energy + "/" + maxEnergy);
                System.out.println("Health: " + health + "/" + maxHealth);
                System.out.println("Damage Dealt: " + damageDealt + "\n");
            }
        }
        else
            System.out.println(name + " is already dead!\n");
    }
    
    public void meditate()
    {
        if(health > 0)
        {
            int d20 = rand.nextInt(20) + 1;
            if(d20 <= 4)
            {
                health = 0;
                System.out.println(name + " rolls a d" + d20 + "! " + name + " attempts to meditate, but gets assassinated!\n");
            }
            else if(d20 <= 9)
            {
                health -= 50;
                System.out.println(name + " rolls a d" + d20 + "! " + name + " attempts to meditate, but gets attacked and takes heavy damage!");
                if(health <= 0)
                {
                    health = 0;
                    System.out.println("This leads to death!\n");
                }
                else
                {
                    energy += (maxEnergy - energy) / 2;
                    System.out.println("However, " + name + " also manages to recover around half of missing energy!");
                }
            }
            else if(d20 <= 14)
            {
                energy += (maxEnergy - energy) / 2;
                System.out.println(name + " rolls a d" + d20 + "! " + name + " meditates and recovers around half of missing energy!");
            }
            else if(d20 <= 19)
            {
                energy += maxEnergy;
                health += 20;
                if(health > maxHealth)
                    health = maxHealth;
                System.out.println(name + " rolls a d" + d20 + "! " + name + " meditates well and recovers all of missing energy and 20 health!");
            }
            else
            {
                energy = maxEnergy;
                health = maxHealth;
                System.out.println(name + " rolls a d" + d20 + "! " + name + " meditates flawlessly, achieving englightenment itself and recovering all energy and health!");
            }
            if(health > 0)
            {
                System.out.println("Energy: " + energy + "/" + maxEnergy);
                System.out.println("Health: " + health + "/" + maxHealth);
                System.out.println("Damage Dealt: " + damageDealt + "\n");
            }
        }
        else
            System.out.println(name + " is already dead!\n");
    }
    
    public String toString()
    {
        return "---------------\n" + "Name: " + name + "\nEnergy: " + energy + "/" + maxEnergy + "\nDamage Dealt: " + damageDealt + "\n---------------\n";
    }
}
