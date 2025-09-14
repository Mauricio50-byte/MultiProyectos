import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.transform.Translate;
import java.util.ArrayList;
import java.util.List;

public class TrafficSimulation extends Application {
    private static final int ROAD_LENGTH = 60; // metros
    private static final double TAU = 2.0; // constante de tiempo del sistema
    
    private Group root3D;
    private List<Vehicle> vehicles;
    private TrafficLight trafficLight1;
    private TrafficLight trafficLight2;
    private PerspectiveCamera camera;

    @Override
    public void start(Stage primaryStage) {
        // Configuración de la escena 3D
        root3D = new Group();
        Scene scene = new Scene(root3D, 1200, 800, true);
        scene.setFill(Color.SKYBLUE);

        // Configuración de la cámara
        camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
            new Translate(0, -100, -200),
            new Rotate(-20, Rotate.X_AXIS)
        );
        scene.setCamera(camera);

        // Crear carretera
        createRoad();

        // Inicializar semáforos
        trafficLight1 = new TrafficLight(-20, 0, 0);
        trafficLight2 = new TrafficLight(20, 0, 0);
        root3D.getChildren().addAll(trafficLight1.getGroup(), trafficLight2.getGroup());

        // Inicializar vehículos
        vehicles = new ArrayList<>();
        initializeVehicles();

        // Configurar y iniciar la animación
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateSimulation();
            }
        };
        timer.start();

        primaryStage.setTitle("Traffic Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createRoad() {
        Box road = new Box(ROAD_LENGTH * 2, 1, 20);
        PhongMaterial roadMaterial = new PhongMaterial();
        roadMaterial.setDiffuseColor(Color.GRAY);
        road.setMaterial(roadMaterial);
        root3D.getChildren().add(road);
    }

    private void initializeVehicles() {
        // Datos estáticos según el documento
        double velocidadPromedio = 40.0; // km/h
        int vehiculosRetenidos = 10;
        int vehiculosPasantes = 20;
        int tiempoRecoleccion = 5; // minutos

        // Cálculos según el documento
        double densidadTrafico = vehiculosRetenidos / (double)ROAD_LENGTH;
        double flujoVehicular = velocidadPromedio * densidadTrafico;

        // Crear vehículos iniciales
        for (int i = 0; i < vehiculosRetenidos; i++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setPosition(-ROAD_LENGTH + (i * 10), 2, 0);
            vehicles.add(vehicle);
            root3D.getChildren().add(vehicle.getModel());
        }

        // Calcular tiempos de semáforo
        updateTrafficLights(vehiculosRetenidos, flujoVehicular);
    }

    private void updateTrafficLights(int N, double Qin) {
        // Calcular tiempo en verde según la fórmula del documento
        double tiempoVerde = -TAU * Math.log(1 - N/Qin);
        
        trafficLight1.setGreenTime(tiempoVerde);
        trafficLight2.setGreenTime(tiempoVerde);
        
        // Alternar los semáforos
        trafficLight1.startCycle();
        trafficLight2.startCycle();
    }

    private void updateSimulation() {
        // Actualizar posición de vehículos
        for (Vehicle vehicle : vehicles) {
            vehicle.update();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class TrafficLight {
    private Group group;
    private Box pole;
    private Cylinder redLight, yellowLight, greenLight;
    private LightState currentState;
    private double greenTime;
    private static final double YELLOW_TIME = 3.0; // segundos

    public enum LightState {
        RED, YELLOW, GREEN
    }

    public TrafficLight(double x, double y, double z) {
        group = new Group();
        
        // Crear poste
        pole = new Box(2, 20, 2);
        PhongMaterial poleMaterial = new PhongMaterial();
        poleMaterial.setDiffuseColor(Color.BLACK);
        pole.setMaterial(poleMaterial);

        // Crear luces
        redLight = createLight(Color.RED);
        yellowLight = createLight(Color.YELLOW);
        greenLight = createLight(Color.GREEN);

        // Posicionar luces
        redLight.setTranslateY(-8);
        yellowLight.setTranslateY(-5);
        greenLight.setTranslateY(-2);

        group.getChildren().addAll(pole, redLight, yellowLight, greenLight);
        group.setTranslateX(x);
        group.setTranslateY(y);
        group.setTranslateZ(z);

        currentState = LightState.RED;
        updateLights();
    }

    private Cylinder createLight(Color color) {
        Cylinder light = new Cylinder(1, 1);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        light.setMaterial(material);
        return light;
    }

    public void setGreenTime(double time) {
        this.greenTime = time;
    }

    public void startCycle() {
        // Implementar ciclo del semáforo
    }

    private void updateLights() {
        // Actualizar visualmente el estado del semáforo
    }

    public Group getGroup() {
        return group;
    }
}

class Vehicle {
    private Box model;
    private double speed;
    private static final double MAX_SPEED = 40.0; // km/h

    public Vehicle() {
        model = new Box(4, 2, 2);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        model.setMaterial(material);
        
        speed = MAX_SPEED;
    }

    public void setPosition(double x, double y, double z) {
        model.setTranslateX(x);
        model.setTranslateY(y);
        model.setTranslateZ(z);
    }

    public void update() {
        // Actualizar posición basada en velocidad y estado de semáforos
        double newX = model.getTranslateX() + (speed * 0.01);
        model.setTranslateX(newX);
    }

    public Box getModel() {
        return model;
    }
}