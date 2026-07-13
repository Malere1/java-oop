package ng.ourChemo.data.models;

import java.time.LocalDateTime;
import java.util.List;

public class DispensedDrugs {

    private int  id;
    private List<DispensedDrug> dispensedDrugs;
    private LocalDateTime saleDateTime;
    private User dispensedBy;
}
