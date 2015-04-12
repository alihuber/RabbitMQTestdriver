# RabbitMQTestdriver
A little Java GUI to send messages to a running RabbitMQ message broker. For further explanation, see the [blog posts here](http://alihuber.github.io/rabbitmq) and the corresponding Ruby on Rails application: [rabbitmq_showcase](https://github.com/alihuber/rabbitmq_showcase).


## Build instructions
It's a standard NetBeans project.
### Dependencies
Depends on Java version 8 (uses lambda expressions, compiled with Java 1.8.0_40) and depends on the [rabbitmq-client.jar](https://www.rabbitmq.com/java-client.html).

### Generated .jar
After successful build you should have a standalone, startable RabbitMQTestdriver.jar in the `dist/` directory.

## Features
Features of RabbitMQ are mapped to tabs on the GUI. The RabbitMQTestdriver implements scenarios partly taken from the official [RabbitMQ tutorial](https://www.rabbitmq.com/getstarted.html) and other broadcasting scenarios to be displayed on the Rails app. All it does is broadcasting messages to the broker that was configured on the first tab:
### Set broker connection
![settings.png](http://alihuber.github.io/images/setttings.png)

Pretty self-explanatory. Note that by default, the Rails app will only display messages that were broadcast to the VHost named "test".
### Smoke test
![settings.png](http://alihuber.github.io/images/smoke.png)

As explained on the label, you are either able to send a single message to the "default" queue, or you can flood the broker and Rails app by sending up to ten thousand random messages.

### Topics
![settings.png](http://alihuber.github.io/images/topic.png)

On this tab you are able to simulate namespaced messages in a contrived 'logging' scenario. As explained on the label, you can feed topic queues of RabbitMQ by sending messages with the appropriate routing key and they will show up in the Rails app accordingly.

### Worker queue
![settings.png](http://alihuber.github.io/images/worker.png)

Functionality on this tab maps more or less directly to the [work queue example](https://www.rabbitmq.com/tutorials/tutorial-two-java.html) of the RabbitMQ tutorial. To simulate round-robin-dispatching, you can add a separate "delay" setting to the message. The message will be consumed by the Rails app after the given amount of seconds.

### Workflow
![settings.png](http://alihuber.github.io/images/workflow.png)

Like stated on the label, the Rails app uses [Sneakers.io](https://github.com/jondot/sneakers.io) to simulate interdependent workflows and re-enqueuing of failed messages. The message text will show up in the Rails app only if it has been acknowledged by the first and second Sneakers.io worker. To make things more fun, the messages will be delayed, rejected 1/10th of the time and re-enqueued automatically, which is observed best by flooding the queues with hundreds of random messages.
