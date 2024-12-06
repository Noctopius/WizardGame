public class MyClient {
    public static void main(String[] args) 
    {
        Wizard alfred = new Wizard("Alfred");
        System.out.print(alfred);
        alfred.castFireball();
        alfred.castFireball();
        alfred.castSelfHeal();
        alfred.castFireball();
        alfred.meditate();
        alfred.castFireball();
        alfred.castFireball();
    }
}
