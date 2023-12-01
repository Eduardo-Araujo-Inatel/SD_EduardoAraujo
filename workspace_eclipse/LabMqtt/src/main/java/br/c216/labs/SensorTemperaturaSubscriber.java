package br.c216.labs;

import java.util.UUID;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class SensorTemperaturaSubscriber {

  public static void main(String[] args) {
    String subscriberId = UUID.randomUUID().toString();
    IMqttClient subscriber = null;

    try {
      subscriber = new MqttClient(MyConstants.URI_BROKER, subscriberId);

      MqttConnectOptions options = new MqttConnectOptions();
      options.setAutomaticReconnect(true);
      options.setCleanSession(true);
      options.setConnectionTimeout(10);
      subscriber.connect(options);

      subscriber.subscribe(
        MyConstants.TOPIC_SENSOR,
        (topic, msg) -> {
          byte[] payload = msg.getPayload();
          System.out.print("Mensagem recebida: " + msg);
          System.out.print("Topico recebido: " + topic);
        }
      );
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        subscriber.close();
      } catch (MqttException e) {}
    }
  }
}
