import { DynamoDBClient, ScanCommand, GetItemCommand  } from "@aws-sdk/client-dynamodb";
import { unmarshall } from "@aws-sdk/util-dynamodb"
/*
Function that handles getting all todo objects or get a single todo object if the id is provided as
a parameter in the API route.

Make sure the DYNAMOTABLENAME and region are set correctly.
Make sure the Lambda has the correct execution role(s)
*/

export const handler = async(event) => {
    console.log('Received event:', JSON.stringify(event, null, 2));
    console.log('any params: ', event.id);
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
        let command;
        
        if(event.pathParameters && event.pathParameters.id){
            // if the event.id is set, only get one item
            const params = {
                TableName: DYNAMODBTABLENAME,
                Key: {
                    _id: {S: event.pathParameters.id}
                }
            };
            command = new GetItemCommand(params);
        }else{
            // Otherwise get all the items
            const params = {
                TableName: DYNAMODBTABLENAME
            };
            command = new ScanCommand(params);
        }
        const response = await client.send(command);
        
        let itemObjects;
        if(response.Items){
            itemObjects = response.Items.map(item => {
            return unmarshall(item);
            });
        }else{
            itemObjects = unmarshall(response.Item);
        }

        body = itemObjects;
        
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
