FROM openjdk:21

RUN groupadd -g 999 appuser \
    && useradd -r -u 999 -g appuser appuser \
    && mkdir -p /app/ \
    && chown -R appuser:appuser /app
WORKDIR /app
USER appuser
COPY --chown=appuser:appuser ./target/javacicd*.jar javacicd.jar
ENTRYPOINT exec java $JAVA_OPTS -jar javacicd.jar