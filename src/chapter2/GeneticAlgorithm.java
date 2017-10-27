package chapter2;

/**
 * Created by mice on 2017/7/8.
 */
public class GeneticAlgorithm {
    private int populationSize;  //种群规模
    private double mutationRate; //遗传突变率
    private double crossoverRate;//杂交率
    private int elitismCount;    //精英数量
    public GeneticAlgorithm(int populationSize,double mutationRate,double crossoverRate,int elitismCount){
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount =elitismCount;
    }

    public Population initPopulation(int chromosomeLenght) {            //实例化种群
        Population population = new Population(this.populationSize,chromosomeLenght);
        return population;
    }

    public double calcFitness(Individual individual) {

        //Track number of cerrct genes
        int correctGenes = 0;

        //Loop over individual's genes
        for (int geneIndex  = 0; geneIndex  < individual.getChromosomeLength(); ++geneIndex ) {
            //Add one fitness point for each "1" found
            if(individual.getGene(geneIndex) == 1) {
                correctGenes += 1;
            }
        }

        double fitness = (double) correctGenes / individual.getChromosomeLength();


        //Store fitness
        individual.setFitness(fitness);
        return fitness;
    }


    public void evalPopulation(Population population) {
        double populationFitness = 0;
        for(Individual individual : population.getIndividuals()) {
            populationFitness += calcFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }
}
