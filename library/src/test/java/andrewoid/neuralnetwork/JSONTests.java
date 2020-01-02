package andrewoid.neuralnetwork;

import andrewoid.neutralnetwork.Network;
import andrewoid.neutralnetwork.NetworkFactory;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JSONTests
{
    @Test
    public void loadFromJSON_correctNumberLayers()
    {
        //given
        String fileName = "C:\\Users\\egass\\IdeaProjects\\neural-network-from-scratch\\testingNetwork.json";
        NetworkFactory networkFactory = new NetworkFactory();

        //when
        Network network = networkFactory.loadFromJSON(fileName);

        //then
        assertEquals(3, network.getLayers().length);
    }

    @Test
    public void loadFromJSON_correctContentsFirstNeuron()
    {
        //given
        String fileName = "C:\\Users\\egass\\IdeaProjects\\neural-network-from-scratch\\testingNetwork.json";
        NetworkFactory networkFactory = new NetworkFactory();

        //when
        Network network = networkFactory.loadFromJSON(fileName);

        //then
        assertEquals(.7, network.getLayers()[0][0].getBias(), .001);
        assertEquals(.33, network.getLayers()[0][0].getDerivative(), .001);
        assertEquals(.709, network.getLayers()[0][0].getValue(), .001);
        assertEquals(.00, network.getLayers()[0][0].getError(), .001);
        assertEquals(0, network.getLayers()[0][0].getNumWeights());
    }

    @Test
    public void saveToJSON_correctNumberLayers()
    {

    }


}
