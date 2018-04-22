package gov.uk.ons.registers.microservice.service

import gov.uk.ons.registers.microservice.config.MyServiceConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MyService @Autowired()(serviceConfig: MyServiceConfig) {
  def getMessage: String = {
    s"The service says: '${serviceConfig.someKey}'"
  }
}
