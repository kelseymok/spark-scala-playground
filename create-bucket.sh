#!/bin/bash

set -ex

bucket_name="${1}"
region="${2:-eu-central-1}"
profile="${3:-default}"
if [ -z "${bucket_name}" ]; then
  echo "Bucket name not set. Exiting. Usage: <bucket-name> <region:-eu-central-1> <profile:-default>"
  exit 1
fi

aws s3api create-bucket \
  --bucket "${bucket_name}" \
  --region "${region}" \
  --profile "${profile}" \
  --acl private \
  --create-bucket-configuration LocationConstraint="${region}"

aws s3api put-public-access-block \
  --bucket "${bucket_name}" \
  --public-access-block-configuration "BlockPublicAcls=true,IgnorePublicAcls=true,BlockPublicPolicy=true,RestrictPublicBuckets=true" \
  --profile "${profile}"
