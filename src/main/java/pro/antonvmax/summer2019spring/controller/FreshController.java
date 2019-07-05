package pro.antonvmax.summer2019spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.antonvmax.summer2019spring.logger.Logging;

@RestController
public class FreshController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Logging("loggerBean")
    private Logger loggerBean;

    @Autowired
    @Logging("")
    private Logger loggerForMyClass;

    @GetMapping("/fresh")
    String fresh() {
        logger.info("logger in fresh() controller");
        loggerBean.info("loggerBean in fresh() controller");
        loggerForMyClass.info("loggerForMyClass in fresh() controller");
        return "Hello from fresh";
    }
}
