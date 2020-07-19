package pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    private String name;

    @NotEmpty
    private String job;

    public User(@NotNull String name, @NotEmpty String job) {
        this.job = job;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
