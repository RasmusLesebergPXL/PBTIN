import {
    S3Client,
    GetObjectCommand,
    ListObjectsV2Command,
  } from "@aws-sdk/client-s3";
import { getSignedUrl } from "@aws-sdk/s3-request-presigner";
/*
Function that reads the contents from an S3 bucket and returns all object urls.
*/
  
export const handler = async(event) => {
    console.log('Received event:', JSON.stringify(event, null, 2));
    
    const bucketName = 'carrousel';
    let body;
    let statusCode = '200';
    const headers = {
        'Content-Type': 'application/json',
        "Access-Control-Allow-Headers" : "*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "*"
    };
    

    try{
        const client = new S3Client({});
    
        const command = new ListObjectsV2Command({
            Bucket: bucketName
        });
        
        const result = await client.send(command);
        
        const publicUrls = await Promise.all(
            result.Contents
                .filter(obj => obj.Size > 0) // exclude zero-byte objects (directories)
                .map(async obj => {
                    const getObjectCommand = new GetObjectCommand({ Bucket: bucketName, Key: obj.Key });
                    const url = await getSignedUrl(client, getObjectCommand, { expiresIn: 3600 });
                    return {url:url};
            })
        );
        body = publicUrls;

        
    }catch(err){
        statusCode = '400';
        body = err.message;
    }finally{
        body = JSON.stringify(body);
    }
    
    return {
        statusCode,
        body,
        headers,
    };
};
