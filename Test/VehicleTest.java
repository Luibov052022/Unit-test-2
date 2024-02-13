import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

class VehicleTest {
    Car car = new Car("Kia", "Cerato", 2015);
    Motorcycle moto = new Motorcycle("Yamaha", "Fazer", 2005 );;

    // проверка того, что экземпляр объекта Car также является экземпляром транспортного средства
    @Test
    void carIsVehicle(){
       assertThat(car instanceof Vehicle);
    }
    //проверка того, объект Car создается с 4-мя колесами
    @Test
    void carHave4Wheels(){
        Car c1 = new Car("Kia", "Cerato", 2015);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
//проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void motoHave2Wheels(){
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }
//проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())

   @Test
    void testDriveCar() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }
//проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void testDriveMoto(){
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }
//проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void parkCar() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

//проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
@Test
void parkMoto(){
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
}
}