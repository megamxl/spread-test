FROM debian:buster

RUN apt-get update && apt-get -y install make gcc ant
COPY spread-src-5.0.1.tar.tar /
RUN tar xvf /spread-src-5.0.1.tar.tar 
RUN cd spread-src-5.0.1 && ./configure && make && make install

RUN apt-get update && apt-get -y install socat man && rm -rf /var/lib/apt/lists/*

RUN ldconfig

COPY spread.conf /
RUN mkdir -p /var/run/spread/ && chown nobody.nogroup /var/run/spread

CMD [ "bash", "-c", "spread" ]

