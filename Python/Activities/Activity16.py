class Car:

    """
    This is a car class
    """
    def __init__(self,manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print (f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        print (f"{self.manufacturer} {self.model} is stopped")    


	
car1 = Car("Tata", "Corolla", "2015", "Manual", "White")
car2 = Car("Hyundai", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")      


car1.accelerate()
car2.stop()
car3.accelerate()