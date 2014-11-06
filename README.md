# luminustest

A simple Luminus test project running on docker/fig in osx.

## Prerequisites

Docker: I used the docker osx installer from: https://docs.docker.com/installation/mac/

Homebrew (for the easy way): http://brew.sh

Fig: `brew install fig`, if you don't want to use Homebrew, follow these steps: http://www.fig.sh/install.html

Leiningen: `brew install leiningen`, or https://github.com/technomancy/leiningen#installation

## Creation steps

This is how this project was created, so you know what happened.

    $ lein new luminus luminustest
    $ cd luminustest

Then add the `Dockerfile` and `fig.yml` (included on this repo).

    cp ~/some/path/{fig.yml,Dockerfile} .

At this point, we have something like this:

    $ ls
    Dockerfile  Procfile    README.md   fig.yml     project.clj resources/  src/        test/

## Running

From now on, you shold be inside a boot2docker terminal, or with the required environment variables set,
this is covered in the docker installation page for osx: https://docs.docker.com/installation/mac/

To build the container and make sure everything is okay:

    $ fig build
    Building web...
    ...
    (lots of stuff)
    ...
     ---> 7eff765cd3e1
    Removing intermediate container c6712f27ab32
    Successfully built 7eff765cd3e1

Then, to start the server:

    $ fig up
    ...
    web_1 | Started server on port 3000

The server is running, but it's listening on a different IP (because of boot2docker), to discover the IP:

    $ boot2docker ip

    The VM's Host only interface IP address is: 192.168.59.103

So, go ahead and open it on your browser: 192.168.59.103:3000


## License

huh?
