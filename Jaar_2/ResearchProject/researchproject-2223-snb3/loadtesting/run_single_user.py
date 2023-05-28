from locust import HttpUser, between, task, run_single_user
import random


class WebsiteUser(HttpUser):
    wait_time = between(1, 10)
    host = "http://10.128.102.3:30001"

    random_priority = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]

    @task(20)
    def index(self):
        with self.client.get(
            "/index.html", 
            catch_response=True) as resp:
            pass
    
    @task(random.choice(random_priority))
    def basket(self):
        with self.client.get(
            "/basket.html", 
            catch_response=True) as resp:
            pass
    
    @task(random.choice(random_priority))
    def basket(self):
        with self.client.get(
            "/card", 
            catch_response=True) as resp:
            pass
    
    @task(random.choice(random_priority))
    def basket(self):
        with self.client.get(
            "/orders", 
            catch_response=True) as resp:
            pass
    
    @task(random.choice(random_priority))
    def basket(self):
        with self.client.get(
            "/address", 
            catch_response=True) as resp:
            pass


    @task(random.choice(random_priority))
    def customer(self):
        with self.client.get(
            "/customers/57a98d98e4b00679b4a830b2",
            catch_response=True) as resp:
            pass


    @task(15)
    def product(self):
        catalogue = ["03fef6ac-1896-4ce8-bd69-b798f85c6e0b", "3395a43e-2d88-40de-b95f-e00e1502085b", "510a0d7e-8e83-4193-b483-e27e09ddc34d", "808a2de1-1aaa-4c25-a9b9-6612e8f29a38", "819e1fbf-8b7e-4f6d-811f-693534916a8b", "837ab141-399e-4c1f-9abc-bace40296bac", "a0a4f044-b040-410d-8ead-4de0446aec7e", "d3588630-ad8e-49df-bbd7-3167f7efb246", "zzz4f044-b040-410d-8ead-4de0446aec7e"]
        random_product = random.choice(catalogue)
        product_url = "/detail.html?id=" +  random_product 
        with self.client.get(
            product_url, 
            catch_response=True) as resp:
            pass
    

    @task(random.choice(random_priority))
    def category(self):
        with self.client.get(
            "/category.html", 
            catch_response=True) as resp:
            pass
    

    task(random.choice(random_priority))
    def customer_orders(self):
        with self.client.get(
            "/customer-orders.html", 
            catch_response=True) as resp:
            pass
        

    @task(random.choice(random_priority))
    def category_pages(self):
        random_page = random.randint(1,3)
        with self.client.get(
            "/category.html?page=" + str(random_page) + "&size=" + str(random_page * 2), 
            catch_response=True) as resp:
            pass
    
    
    @task(random.choice(random_priority))
    def category_types(self):
        random_colour = ["sport", "black", "geek", "magic", "skin", "blue", "red", "brown", "green", "formal", "toes", "smelly", "large", "small"]
        tags = set()
        while len(tags) < 3:
            tags.add(random.choice(random_colour))
        tags_str = "%2C".join(tags)
        with self.client.get("/category.html?tags=" + tags_str, catch_response=True) as resp:
            pass

    

if __name__ == "__main__":
    run_single_user(WebsiteUser)
