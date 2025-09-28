public class Monster{
    private int MonsterHP;
    private int MonsterAttack;
    private int MonsterLevel;

    public Monster(int round){
        MonsterHP = 25;
        MonsterAttack = 5;
        MonsterLevel = round;
    }

    public void monsterDamaged(int damage){
        MonsterHP -= damage;
        if(MonsterHP < 0){
            MonsterHP = 0;
        }
    }

    public void increaseMonster(int round){
        MonsterHP += 25 * round;
        MonsterAttack += 3 * round;
    }

    public int getMonsterHP(){
        return MonsterHP;
    }

    public int getMonsterAttack(){
        return MonsterAttack;
    }

    public int getMonsterLevel(){
        return MonsterLevel;
    }
}