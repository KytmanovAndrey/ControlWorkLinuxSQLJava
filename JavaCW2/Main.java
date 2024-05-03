import service.AnimalRegistryService;
import view.AnimalRegistryView;

public class Main {
    public static void main(String[] args) {
        AnimalRegistryView animalRegistryView = new AnimalRegistryView(new AnimalRegistryService());
        animalRegistryView.showUI();
    }
}
