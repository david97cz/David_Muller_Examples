## DevOps Lifecycle

1. **Planning (Plan)**
    - Setting clear and measurable goals.
    - Defining the project scope.
    - Analyzing requirements of **end users**.
    - Defining roles and responsibilities of each team member - **Developer**, **Release Manager**, **Tester**, **Support**, **DevOps Engineer**.

2. **Development and Coding (Code)**
    - **Developer** writes code according to specified requirements.
    - The code is continuously stored in **GitLab**, which ensures version control.
    - Developers perform code reviews to detect errors and improve quality.
    - Documentation is an important part of development, describing how the code works, how to use it, and how to extend it.
    - **DevOps Engineer** configures and manages version control tools.

3. **Building the Application from Code (Build)**
    - Converting the written code into an executable form.
    - **DevOps Engineer** automates the build processes.
    - Uploading the application to **Docker** - creating a Dockerfile.
    - Using the "build" command to create an image.
    - Using the "run" command to start the image and create a container.
    - For managing a larger number of containers, **Kubernetes** can be used.
    - For managing Kubernetes clusters, **Rancher** can be utilized.

4. **Testing the Application (Test)**
    - Testing ensures that the code works correctly.
    - **Tester** takes the new build, which is automatically deployed to the testing environment using **Kubernetes**.
    - Automated tests, manual tests, performance tests, and security tests are conducted.

5. **Releasing the Application (Release)**
    - **Release Manager** verifies that the application has passed all necessary tests and ensures that the application is stable and ready for deployment.
    - Ensuring final approval from all stakeholders.
    - **Helm** can be used - providing complete information about managing the application's lifecycle.

6. **Deploying the Application (Deploy)**
    - Implementing a new version of the application into the production environment at the **end customer**.
    - **HashiCorp Vault** provides better control over sensitive data and helps meet cloud security standards.
    - **DevOps Engineer** automates processes for fast and reliable deployment.

7. **Operation (Operation)**
    - **DevOps Engineer** monitors the application and responds to any incidents or issues.
    - **Rancher** can be used to monitor the performance and availability of the application.

8. **Monitoring (Monitoring)**
    - **Accountant** monitors financial transactions and manages billing in the e-shop.
    - **Support** gathers feedback from **end users** and provides reports for further improvements.
