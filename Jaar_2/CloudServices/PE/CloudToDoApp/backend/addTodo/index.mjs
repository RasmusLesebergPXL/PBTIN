import { DynamoDBClient, PutItemCommand  } from "@aws-sdk/client-dynamodb";
import { marshall, unmarshall } from "@aws-sdk/util-dynamodb"
import  { randomUUID } from "crypto";
/*
Function that handles adding a todo object to DynamoDB.
Todo object must have a _id property as a primary key. They also have the properties
title (string), label (string) and completed (boolean).

Make sure the DYNAMOTABLENAME and region are set correctly.
Make sure the Lambda has the correct execution role(s)
*/
export const handler = async(event) => {
    console.log('Received event:', JSON.stringify(event, null, 2));
    
    const DYNAMODBTABLENAME = 'todo';
    let body;
    let statusCode = '200';
    const headers = {
        'Content-Type': 'application/json',
        "Access-Control-Allow-Headers" : "*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "*"
    };
    const client = new DynamoDBClient({ region: 'us-east-1' });
    
    try{
        const item = JSON.parse(event.body);
        if(!item.title || !item.label)
            throw new Error("Missing title or label property");
        const postInput = {
                TableName: DYNAMODBTABLENAME,
                Item: {
                    _id: {S: randomUUID()},
                    title: {S: item.title},
                    label: {S: item.label},
                    completed: {BOOL: item.completed}
                }
              }
    
        const Putcommand = new PutItemCommand(postInput);
        const putResponse = await client.send(Putcommand);
        body = unmarshall(postInput.Item);
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
