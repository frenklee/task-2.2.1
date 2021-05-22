package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Car {

    @Column(name = "model")
    private String model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int series;

    @OneToOne
    @JoinColumn(name="id")
    private User user;

    public Car(){}

    public Car(String model, int series){
        this.model = model;
        this.series = series;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


}
