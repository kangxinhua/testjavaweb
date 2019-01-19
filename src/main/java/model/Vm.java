package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Vm {
    private String id;
    private String name;
    private String project;
    private String application;

}
