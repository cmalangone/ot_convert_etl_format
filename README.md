# Open Targets Platform Converter


## Running locally

If authentication is already set up you don't need to do anything, as Google Application Default Credentials (ADC)
resolution mechanism will find the appropriate credentials in the default location.

You can also use environment variables or Google Secret Manager.

Create a jar file with the `sbt assembly` command from the directory containing
the `build.sbt` file. A jar file will be generated in the `/target/scala-2.12/` directory.

To run the jar use the following command to display the help text:

`java -jar target/scala-2.12/ot-conversion-format.jar --help`

### Using environment variable

`export GOOGLE_APPLICATION_CREDENTIALS="<path to secret key json file>"`

### Using Secret Manager

1. If you don't already have authorisation set-up, create a new Key on an appropriate service
account and save that json file locally.
2. Add that key to [GCP Secret Manager](https://cloud.google.com/secret-manager)
3. Run `gcloud auth login --update-adc` to configure local account to use Secret Manager keys.

## Dependency documentation

- [Scala XML](https://github.com/scala/scala-xml/wiki)
- [Scopt](https://github.com/scopt/scopt): Used to generate the command line interface.
- [GCP Java APIs](https://cloud.google.com/java/docs/reference)
  - [ResourceManager](https://googleapis.dev/java/google-cloud-resourcemanager/latest/index.html) - Centrally manage all your projects, IAM, and resource containers.
  - [Storage](https://googleapis.dev/java/google-cloud-storage/latest/index.html) - GCP storage
