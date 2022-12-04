package Season.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinterDto implements Serializable {

    private static final long serialVersionUID = 3098784982085101512L;

    private Long id;

    private String code;

    private String description;

}