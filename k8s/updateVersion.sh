#!/bin/bash

#Error handling function called by trap command below
function on_err
{
    local rc=$?

    echo "script failure exit code [${rc}], line [${BASH_LINENO}]"
    exit 1
}

trap on_err ERR

# Get the deploy.yml from k8's folder and provide the access to modify it
DEPLOYMENT_TEMPLATE=deploy.yml
chmod a+rwx "$DEPLOYMENT_TEMPLATE"

# Replace the deui parameters inside the deploy.yml with the environment variables
sed -i "s/<SERVICE_VERSION>/$SERVICE_VERSION/g" $DEPLOYMENT_TEMPLATE

# Display template
echo "----Updated Template----"
cat ${DEPLOYMENT_TEMPLATE}