package test.java.endtoend;

import org.junit.Before;
import org.junit.Test;

import main.java.entities.apartment.ApartmentFactory;

/**
 * End-to-end test. Only one scenario is tested.
 *
 * @author leshak
 *
 */
public class DevicesAppEndToEndTest {

    private int numberOfDevices;
    private ApartmentFactory factory;
    private InteractionService helper;
    private Calculator calculator;
    private SorterService sorter;
    private SearchService searchEngine;

    @Before
    public void init() {
        numberOfDevices = 10;
        factory = new ApartmentFactory();
        helper = new InteractionHelper();
        calculator = new Calculator();
        sorter = new SorterService();
        searchEngine = new SearchService();
    }

    @Test
    public void shouldPassRequiredScenario() {

        Apartment ap = factory.createApartmentWithNumberOfDevicesEqualTo(numberOfDevices);
        helper.displayDevicesAndMenu(ap);
        List<Device> devices = helper.getDevicesToBePlugged(ap);
        int totalCapacity = calculator.calculateTotalCapacity(devices);
        helper.displayMessage(totalCapacity);
        helper.displayDevices(sorter.sortByCapacity(devices));
        Range<Integer> capacityRange = new Range(300. 700);
        Range<String> modelRange = new Range("aa", "gg");
        helper.displayDevices(searchEngine.searchDevicesCorrespondingTo(capacityRange, modelRange));
    }
}
