package lesson1;

public class Course {

    private Pool[] coursePool;

    public Course(Pool[] coursePool) {
        this.coursePool = coursePool;
    }

    public void doIt(Team team){
        int i = 0;
        for (Pool pool : getCoursePool()){
            team.addResults("Препятствие " + (++i) + ":\n");
            for (Animal animal: team.getTeamGroup()) {
                if ( pool.getTimeToOvercomePool(animal) <= pool.getMaxTimeSwimming() ) {
                    team.addResults("\t" + animal.getName() + " справился\n");
                }
                else {
                    team.addResults("\t" + animal.getName() + " не справился\n");
                }
            }
        }
    }

    public Pool[] getCoursePool() {
        return coursePool;
    }

    public void setCoursePool(Pool[] coursePool) {
        this.coursePool = coursePool;
    }
}
